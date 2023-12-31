//package com.luxoft.bankapp.email;
//
//import java.io.Serializable;
//
//public class EmailService implements Runnable, Serializable {
//
//	private static final long serialVersionUID = -6872857384878095572L;
//	private Queue queue = new Queue();
//	private boolean closed;
//    private int sentEmails = 0;
//
//	public EmailService() {
//    	new Thread(this).start();
//    }
//
//    @Override
//    public void run() {
//        Email email;
//        while (true) {
//        	if(closed) {
//            	return;
//            }
//
//            if ((email = queue.get()) != null) {
//                sendEmail(email);
//            }
//            try {
//            	synchronized(queue) {
//            		queue.wait();
//            	}
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//                return;
//            }
//
//        }
//    }
//
//    public int getSentEmails() {
//		return sentEmails;
//	}
//
//    private void sendEmail(Email email) {
//        System.out.println(email);
//        sentEmails++;
//    }
//
//    public void sendNotificationEmail(Email email) throws EmailException {
//        if (!closed) {
//            queue.add(email);
//        	synchronized(queue) {
//        		queue.notify();
//        	}
//        } else
//            throw new EmailException("Mailbox is closed!");
//    }
//
//    public void close() {
//    	closed = true;
//    	synchronized(queue) {
//    		queue.notify();
//	    }
//    }
//
//}

//exercise 3

package com.luxoft.bankapp.email;
import java.io.Serializable;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class EmailService implements Runnable, Serializable {

    private static final long serialVersionUID = -6872857384878095572L;
    private Queue queue = new Queue();
    private boolean closed;
    private int sentEmails = 0;

    public EmailService() {
        new Thread(this).start();
    }

    @Override
    public void run() {
        Email email;
        while (true) {
            if (closed) {
                return;
            }

            if ((email = queue.get()) != null) {
                sendEmail(email);
            }
            try {
                synchronized (queue) {
                    queue.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            }

        }
    }

    public int getSentEmails() {
        return sentEmails;
    }

    private void sendEmail(Email email) {
        System.out.println(email);
        sentEmails++;
    }

    public void sendNotificationEmail(Email email) throws EmailException {
        if (!closed) {
            queue.add(email);
            synchronized (queue) {
                queue.notify();
            }
        } else {
            throw new EmailException("Mailbox is closed!");
        }
    }

    public void close() {
        closed = true;
        synchronized (queue) {
            queue.notify();
        }
    }

    static class Queue implements Serializable {

        private static final long serialVersionUID = -367534955230149744L;

        private List<Email> emails = Collections.synchronizedList(new LinkedList<>());

        public void add(Email email) {
            emails.add(email);
        }

        public Email get() {
            if (emails.size() > 0) {
                return emails.remove(emails.size() - 1);
            }

            return null;
        }
    }
}

