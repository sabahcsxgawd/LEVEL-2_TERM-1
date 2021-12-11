import java.util.Scanner;

class Customer {
    private int id;
    private int enterTime;
    private int serviceTime;

    public Customer() {

    }

    public Customer(int id, int enterTime, int serviceTime) {
        this.id = id;
        this.enterTime = enterTime;
        this.serviceTime = serviceTime;
    }

    public Customer(Customer customer) {
        this.id = customer.id;
        this.enterTime = customer.enterTime;
        this.serviceTime = customer.serviceTime;
    }

    public int getId() {
        return this.id;
    }

    public int getEnterTime() {
        return this.enterTime;
    }

    public int getServiceTime() {
        return this.serviceTime;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEnterTime(int enterTime) {
        this.enterTime = enterTime;
    }

    public void setServiceTime(int serviceTime) {
        this.serviceTime = serviceTime;
    }

}


public class Bank2 {
    private static void LLQueueBank() {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int booth1EndTime, booth2EndTime;
        booth1EndTime = booth2EndTime = 0;
        LLQueue booth1 = new LLQueue();
        LLQueue booth2 = new LLQueue();
        for (int i = 0; i < n; i++) {
            int t, s;
            t = scn.nextInt();
            s = scn.nextInt();
            Customer customer = new Customer(i + 1, t, s);
            if (booth1EndTime == 0) {
                booth1.enqueue(customer);
                booth1EndTime = t + s;
            } else if (booth2EndTime == 0) {
                booth2.enqueue(customer);
                booth2EndTime = t + s;
            } else if (t < booth1EndTime && t < booth2EndTime) {
                if (booth1.length() <= booth2.length()) {
                    booth1.enqueue(customer);
                    if (booth1.length() == 1) {
                        booth1EndTime = t + s;
                    }
                } else {
                    booth2.enqueue(customer);
                    if (booth2.length() == 1) {
                        booth2EndTime = t + s;
                    }
                }
            } else {
                while (true) {
                    boolean isDeq = false;
                    boolean isEnq = false;
                    if (booth1EndTime == booth2EndTime && booth1EndTime <= t) {
                        if (booth1.length() > 0) {
                            Customer temp = (Customer) booth1.dequeue();
                            isDeq = true;
                            if (booth1.length() > 0) {
                                Customer temp2 = (Customer) booth1.frontValue();
                                booth1EndTime += temp2.getServiceTime();
                            }
                        }
                        if (booth2.length() > 0) {
                            Customer temp = (Customer) booth2.dequeue();
                            isDeq = true;
                            if (booth2.length() > 0) {
                                Customer temp2 = (Customer) booth2.frontValue();
                                booth2EndTime += temp2.getServiceTime();
                            }
                        }
                        if (booth1EndTime == t) {
                            isEnq = true;
                            if (booth1.length() <= booth2.length()) {
                                booth1.enqueue(customer);
                                if (booth1.length() == 1) {
                                    booth1EndTime = t + s;
                                }
                            } else {
                                booth2.enqueue(customer);
                                if (booth2.length() == 1) {
                                    booth2EndTime = t + s;
                                }
                            }
                        }
                        if (booth1.length() - booth2.length() >= 2) {
                            booth2.enqueue(booth1.leaveQueue());
                            if (booth2.length() == 1) {
                                Customer temp2 = (Customer) booth2.frontValue();
                                booth2EndTime += temp2.getServiceTime();
                            }
                        } else if (booth2.length() - booth1.length() >= 2) {
                            booth1.enqueue(booth2.leaveQueue());
                            if (booth1.length() == 1) {
                                Customer temp2 = (Customer) booth1.frontValue();
                                booth1EndTime += temp2.getServiceTime();
                            }
                        }
                    }
                    else if (booth1EndTime < booth2EndTime && booth1EndTime <= t) {
                        if (booth1.length() > 0) {
                            Customer temp = (Customer) booth1.dequeue();
                            isDeq = true;
                            if (booth1.length() > 0) {
                                Customer temp2 = (Customer) booth1.frontValue();
                                booth1EndTime += temp2.getServiceTime();
                            }
                        }
                        if (booth1EndTime == t) {
                            isEnq = true;
                            if (booth1.length() <= booth2.length()) {
                                booth1.enqueue(customer);
                                if (booth1.length() == 1) {
                                    booth1EndTime = t + s;
                                }
                            } else {
                                booth2.enqueue(customer);
                                if (booth2.length() == 1) {
                                    booth2EndTime = t + s;
                                }
                            }
                        }
                        if (booth1.length() - booth2.length() >= 2) {
                            booth2.enqueue(booth1.leaveQueue());
                            if (booth2.length() == 1) {
                                Customer temp2 = (Customer) booth2.frontValue();
                                booth2EndTime += temp2.getServiceTime();
                            }
                        } else if (booth2.length() - booth1.length() >= 2) {
                            booth1.enqueue(booth2.leaveQueue());
                            if (booth1.length() == 1) {
                                Customer temp2 = (Customer) booth1.frontValue();
                                booth1EndTime += temp2.getServiceTime();
                            }
                        }
                    }
                    else if (booth2EndTime < booth1EndTime && booth2EndTime <= t) {
                        if (booth2.length() > 0) {
                            Customer temp = (Customer) booth2.dequeue();
                            isDeq = true;
                            if (booth2.length() > 0) {
                                Customer temp2 = (Customer) booth2.frontValue();
                                booth2EndTime += temp2.getServiceTime();
                            }
                        }
                        if (booth2EndTime == t) {
                            isEnq = true;
                            if (booth2.length() <= booth2.length()) {
                                booth2.enqueue(customer);
                                if (booth2.length() == 1) {
                                    booth2EndTime = t + s;
                                }
                            } else {
                                booth1.enqueue(customer);
                                if (booth1.length() == 1) {
                                    booth1EndTime = t + s;
                                }
                            }
                        }
                        if (booth1.length() - booth2.length() >= 2) {
                            booth2.enqueue(booth1.leaveQueue());
                            if (booth2.length() == 1) {
                                Customer temp2 = (Customer) booth2.frontValue();
                                booth2EndTime += temp2.getServiceTime();
                            }
                        } else if (booth2.length() - booth1.length() >= 2) {
                            booth1.enqueue(booth2.leaveQueue());
                            if (booth1.length() == 1) {
                                Customer temp2 = (Customer) booth1.frontValue();
                                booth1EndTime += temp2.getServiceTime();
                            }
                        }
                    }
                    if (!isDeq) {
                        if (booth1.length() <= booth2.length()) {
                            booth1.enqueue(customer);
                            isEnq = true;
                            if (booth1.length() == 1) {
                                booth1EndTime = t + s;
                            }
                        } else {
                            booth2.enqueue(customer);
                            isEnq = true;
                            if (booth2.length() == 1) {
                                booth2EndTime = t + s;
                            }
                        }
                        if (booth1.length() - booth2.length() >= 2) {
                            booth2.enqueue(booth1.leaveQueue());
                            if (booth2.length() == 1) {
                                booth2EndTime = t + s;
                            }
                        } else if (booth2.length() - booth1.length() >= 2) {
                            booth1.enqueue(booth2.leaveQueue());
                            if (booth1.length() == 1) {
                                booth1EndTime = t + s;
                            }
                        }
                        break;
                    }
                    if (isEnq) {
                        break;
                    }
                }
            }
        }
        scn.close();
//        System.out.println(booth1EndTime);
//        System.out.println(booth2EndTime);
        while (booth1.length() > 0 || booth2.length() > 0) {
            int minTime = Math.min(booth1EndTime, booth2EndTime);
            if (booth1.length() == 0 && booth2.length() != 0) {
                minTime = booth2EndTime;
            } else if (booth1.length() != 0 && booth2.length() == 0) {
                minTime = booth1EndTime;
            }
            if (booth1EndTime == minTime) {
                if (booth1.length() > 0) {
                    Customer temp = (Customer) booth1.dequeue();
                    if (booth1.length() > 0) {
                        booth1EndTime += ((Customer) booth1.frontValue()).getServiceTime();
                    }
                }
            }
            if (booth2EndTime == minTime) {
                if (booth2.length() > 0) {
                    Customer temp = (Customer) booth2.dequeue();
                    if (booth2.length() > 0) {
                        booth2EndTime += ((Customer) booth2.frontValue()).getServiceTime();
                    }
                }
            }
            if (booth1.length() - booth2.length() >= 2) {
                while (booth1.length() - booth2.length() >= 2) {
                    booth2.enqueue(booth1.leaveQueue());
                    if (booth2.length() == 1) {
                        Customer temp2 = (Customer) booth2.frontValue();
                        booth2EndTime += temp2.getServiceTime();
                    }
                }
            } else if (booth2.length() - booth1.length() >= 2) {
                while (booth2.length() - booth1.length() >= 2) {
                    booth1.enqueue(booth2.leaveQueue());
                    if (booth1.length() == 1) {
                        Customer temp2 = (Customer) booth1.frontValue();
                        booth1EndTime += temp2.getServiceTime();
                    }
                }
            }
        }
        System.out.println("Booth 1 finishes service at t=" + booth1EndTime);
        System.out.println("Booth 2 finishes service at t=" + booth2EndTime);
    }

    private static void ArrQueueBank() {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int booth1EndTime, booth2EndTime;
        booth1EndTime = booth2EndTime = 0;
        ArrQueue booth1 = new ArrQueue();
        ArrQueue booth2 = new ArrQueue();
        for (int i = 0; i < n; i++) {
            int t, s;
            t = scn.nextInt();
            s = scn.nextInt();
            Customer customer = new Customer(i + 1, t, s);
            if (booth1EndTime == 0) {
                booth1.enqueue(customer);
                booth1EndTime = t + s;
            } else if (booth2EndTime == 0) {
                booth2.enqueue(customer);
                booth2EndTime = t + s;
            } else if (t < booth1EndTime && t < booth2EndTime) {
                if (booth1.length() <= booth2.length()) {
                    booth1.enqueue(customer);
                    if (booth1.length() == 1) {
                        booth1EndTime = t + s;
                    }
                } else {
                    booth2.enqueue(customer);
                    if (booth2.length() == 1) {
                        booth2EndTime = t + s;
                    }
                }
            } else {
                while (true) {
                    boolean isDeq = false;
                    boolean isEnq = false;
                    if (booth1EndTime == booth2EndTime && booth1EndTime <= t) {
                        if (booth1.length() > 0) {
                            Customer temp = (Customer) booth1.dequeue();
                            isDeq = true;
                            if (booth1.length() > 0) {
                                Customer temp2 = (Customer) booth1.frontValue();
                                booth1EndTime += temp2.getServiceTime();
                            }
                        }
                        if (booth2.length() > 0) {
                            Customer temp = (Customer) booth2.dequeue();
                            isDeq = true;
                            if (booth2.length() > 0) {
                                Customer temp2 = (Customer) booth2.frontValue();
                                booth2EndTime += temp2.getServiceTime();
                            }
                        }
                        if (booth1EndTime == t) {
                            isEnq = true;
                            if (booth1.length() <= booth2.length()) {
                                booth1.enqueue(customer);
                                if (booth1.length() == 1) {
                                    booth1EndTime = t + s;
                                }
                            } else {
                                booth2.enqueue(customer);
                                if (booth2.length() == 1) {
                                    booth2EndTime = t + s;
                                }
                            }
                        }
                        if (booth1.length() - booth2.length() >= 2) {
                            booth2.enqueue(booth1.leaveQueue());
                            if (booth2.length() == 1) {
                                Customer temp2 = (Customer) booth2.frontValue();
                                booth2EndTime += temp2.getServiceTime();
                            }
                        } else if (booth2.length() - booth1.length() >= 2) {
                            booth1.enqueue(booth2.leaveQueue());
                            if (booth1.length() == 1) {
                                Customer temp2 = (Customer) booth1.frontValue();
                                booth1EndTime += temp2.getServiceTime();
                            }
                        }
                    }
                    else if (booth1EndTime < booth2EndTime && booth1EndTime <= t) {
                        if (booth1.length() > 0) {
                            Customer temp = (Customer) booth1.dequeue();
                            isDeq = true;
                            if (booth1.length() > 0) {
                                Customer temp2 = (Customer) booth1.frontValue();
                                booth1EndTime += temp2.getServiceTime();
                            }
                        }
                        if (booth1EndTime == t) {
                            isEnq = true;
                            if (booth1.length() <= booth2.length()) {
                                booth1.enqueue(customer);
                                if (booth1.length() == 1) {
                                    booth1EndTime = t + s;
                                }
                            } else {
                                booth2.enqueue(customer);
                                if (booth2.length() == 1) {
                                    booth2EndTime = t + s;
                                }
                            }
                        }
                        if (booth1.length() - booth2.length() >= 2) {
                            booth2.enqueue(booth1.leaveQueue());
                            if (booth2.length() == 1) {
                                Customer temp2 = (Customer) booth2.frontValue();
                                booth2EndTime += temp2.getServiceTime();
                            }
                        } else if (booth2.length() - booth1.length() >= 2) {
                            booth1.enqueue(booth2.leaveQueue());
                            if (booth1.length() == 1) {
                                Customer temp2 = (Customer) booth1.frontValue();
                                booth1EndTime += temp2.getServiceTime();
                            }
                        }
                    }
                    else if (booth2EndTime < booth1EndTime && booth2EndTime <= t) {
                        if (booth2.length() > 0) {
                            Customer temp = (Customer) booth2.dequeue();
                            isDeq = true;
                            if (booth2.length() > 0) {
                                Customer temp2 = (Customer) booth2.frontValue();
                                booth2EndTime += temp2.getServiceTime();
                            }
                        }
                        if (booth2EndTime == t) {
                            isEnq = true;
                            if (booth2.length() <= booth2.length()) {
                                booth2.enqueue(customer);
                                if (booth2.length() == 1) {
                                    booth2EndTime = t + s;
                                }
                            } else {
                                booth1.enqueue(customer);
                                if (booth1.length() == 1) {
                                    booth1EndTime = t + s;
                                }
                            }
                        }
                        if (booth1.length() - booth2.length() >= 2) {
                            booth2.enqueue(booth1.leaveQueue());
                            if (booth2.length() == 1) {
                                Customer temp2 = (Customer) booth2.frontValue();
                                booth2EndTime += temp2.getServiceTime();
                            }
                        } else if (booth2.length() - booth1.length() >= 2) {
                            booth1.enqueue(booth2.leaveQueue());
                            if (booth1.length() == 1) {
                                Customer temp2 = (Customer) booth1.frontValue();
                                booth1EndTime += temp2.getServiceTime();
                            }
                        }
                    }
                    if (!isDeq) {
                        if (booth1.length() <= booth2.length()) {
                            booth1.enqueue(customer);
                            isEnq = true;
                            if (booth1.length() == 1) {
                                booth1EndTime = t + s;
                            }
                        } else {
                            booth2.enqueue(customer);
                            isEnq = true;
                            if (booth2.length() == 1) {
                                booth2EndTime = t + s;
                            }
                        }
                        if (booth1.length() - booth2.length() >= 2) {
                            booth2.enqueue(booth1.leaveQueue());
                            if (booth2.length() == 1) {
                                booth2EndTime = t + s;
                            }
                        } else if (booth2.length() - booth1.length() >= 2) {
                            booth1.enqueue(booth2.leaveQueue());
                            if (booth1.length() == 1) {
                                booth1EndTime = t + s;
                            }
                        }
                        break;
                    }
                    if (isEnq) {
                        break;
                    }
                }
            }
        }
        scn.close();
//        System.out.println(booth1EndTime);
//        System.out.println(booth2EndTime);
        while (booth1.length() > 0 || booth2.length() > 0) {
            int minTime = Math.min(booth1EndTime, booth2EndTime);
            if (booth1.length() == 0 && booth2.length() != 0) {
                minTime = booth2EndTime;
            } else if (booth1.length() != 0 && booth2.length() == 0) {
                minTime = booth1EndTime;
            }
            if (booth1EndTime == minTime) {
                if (booth1.length() > 0) {
                    Customer temp = (Customer) booth1.dequeue();
                    if (booth1.length() > 0) {
                        booth1EndTime += ((Customer) booth1.frontValue()).getServiceTime();
                    }
                }
            }
            if (booth2EndTime == minTime) {
                if (booth2.length() > 0) {
                    Customer temp = (Customer) booth2.dequeue();
                    if (booth2.length() > 0) {
                        booth2EndTime += ((Customer) booth2.frontValue()).getServiceTime();
                    }
                }
            }
            if (booth1.length() - booth2.length() >= 2) {
                while (booth1.length() - booth2.length() >= 2) {
                    booth2.enqueue(booth1.leaveQueue());
                    if (booth2.length() == 1) {
                        Customer temp2 = (Customer) booth2.frontValue();
                        booth2EndTime += temp2.getServiceTime();
                    }
                }
            } else if (booth2.length() - booth1.length() >= 2) {
                while (booth2.length() - booth1.length() >= 2) {
                    booth1.enqueue(booth2.leaveQueue());
                    if (booth1.length() == 1) {
                        Customer temp2 = (Customer) booth1.frontValue();
                        booth1EndTime += temp2.getServiceTime();
                    }
                }
            }
        }
        System.out.println("Booth 1 finishes service at t=" + booth1EndTime);
        System.out.println("Booth 2 finishes service at t=" + booth2EndTime);
    }

    public static void main(String[] args) {
        ArrQueueBank();
//        LLQueueBank();
    }
}
