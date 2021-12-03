import java.util.Scanner;


class Dish {
    private int friend;
    private int time;
    private int course;

    public Dish(Dish dish) {
        this.friend = dish.friend;
        this.time = dish.time;
        this.course = dish.course;
    }

    public Dish(int friend, int time, int course) {
        this.friend = friend;
        this.time = time;
        this.course = course;
    }

    public Dish() {

    }

    public int getCourse() {
        return this.course;
    }

    public int getFriend() {
        return this.friend;
    }

    public int getTime() {
        return this.time;
    }

    public void setFriend(int friend) {
        this.friend = friend;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void setCourse(int course) {
        this.course = course;
    }
}

public class DishWasher {

    private static void LLStackDishWasher() {
        LLStack dirtyStack = new LLStack();
        LLStack cleanStack = new LLStack();
        LLStack fullStack = new LLStack();
        LLStack endTimeStack = new LLStack();
        Integer startTime = 0, busyTime = -1;
        Integer k, t, s;
        Scanner scn = new Scanner(System.in);
        Integer n, x;
        n = scn.nextInt();
        x = scn.nextInt();
        Integer[] a = new Integer[x + 1];
        for (int i = 1; i <= x; i++) {
            a[i] = scn.nextInt();
        }
        while (true) {

            k = scn.nextInt();
            t = scn.nextInt();
            s = scn.nextInt();

            Dish dish = new Dish(k, t, s);

            if (k == 0) {
                while (dirtyStack.length() > 0) {
                    Dish temp = (Dish) dirtyStack.pop();
                    busyTime = startTime + a[temp.getCourse()] - 1;
                    startTime = busyTime + 1;
//                    System.out.println(busyTime);
                    cleanStack.push(temp);
                    endTimeStack.push(busyTime);
                }
                scn.close();
                break;
            } else {
                if (s == x) {
                    fullStack.push(dish);
                }
                if (t < startTime) {
                    dirtyStack.push(dish);
                } else if (t == startTime) {
                    dirtyStack.push(dish);
                    Dish temp = (Dish) dirtyStack.pop();
                    busyTime = startTime + a[temp.getCourse()] - 1;
                    startTime = busyTime + 1;
//                    System.out.println(busyTime);
                    cleanStack.push(temp);
                    endTimeStack.push(busyTime);
                } else {
                    while (dirtyStack.length() > 0 && t > startTime) {
                        Dish temp = (Dish) dirtyStack.pop();
                        busyTime = startTime + a[temp.getCourse()] - 1;
                        startTime = busyTime + 1;
//                        System.out.println(busyTime);
                        cleanStack.push(temp);
                        endTimeStack.push(busyTime);
                    }
                    if (startTime <= t) {
                        dirtyStack.push(dish);
                        Dish temp = (Dish) dirtyStack.pop();
                        startTime = t;
                        busyTime = startTime + a[temp.getCourse()] - 1;
                        startTime = busyTime + 1;
//                        System.out.println(busyTime);
                        cleanStack.push(temp);
                        endTimeStack.push(busyTime);
                    } else {
                        dirtyStack.push(dish);
                    }
                }
            }
        }
        System.out.println(endTimeStack.topValue());
        Integer[] endTime = new Integer[endTimeStack.length()];
        int index1 = 0;
        int index2 = 0;
        Dish[] fullMeal = new Dish[fullStack.length()];
        while (endTimeStack.length() > 0) {
            endTime[index1++] = (Integer) endTimeStack.pop();
        }
        for (int i = index1 - 1; i >= 0; i--) {
            if (i == index1 - 1) {
                System.out.print(endTime[i]);
            } else {
                System.out.print("," + endTime[i]);
            }
            endTimeStack.push(endTime[i]);
        }
        System.out.println("");
        if (fullStack.length() == n) {
            System.out.println("Y");
        } else {
            System.out.println("N");
        }
        while (fullStack.length() > 0) {
            fullMeal[index2++] = (Dish) fullStack.pop();
        }
        for (int i = index2 - 1; i >= 0; i--) {
            if (i == index2 - 1) {
                System.out.print(fullMeal[index2 - 1 - i].getFriend());
            } else {
                System.out.print("," + fullMeal[index2 - 1 - i].getFriend());
            }
            fullStack.push(fullMeal[index2 - 1 - i]);
        }
    }

    private static void ArrStackDishWasher() {
        Integer startTime = 0, busyTime = -1;
        Integer k, t, s;
        Scanner scn = new Scanner(System.in);
        Integer n, x;
        n = scn.nextInt();
        x = scn.nextInt();
        ArrStack dirtyStack = new ArrStack(n*x);
        ArrStack cleanStack = new ArrStack(n*x);
        ArrStack fullStack = new ArrStack(n);
        ArrStack endTimeStack = new ArrStack(n*x);
        Integer[] a = new Integer[x + 1];
        for (int i = 1; i <= x; i++) {
            a[i] = scn.nextInt();
        }
        while (true) {

            k = scn.nextInt();
            t = scn.nextInt();
            s = scn.nextInt();

            Dish dish = new Dish(k, t, s);

            if (k == 0) {
                while (dirtyStack.length() > 0) {
                    Dish temp = (Dish) dirtyStack.pop();
                    busyTime = startTime + a[temp.getCourse()] - 1;
                    startTime = busyTime + 1;
//                    System.out.println(busyTime);
                    cleanStack.push(temp);
                    endTimeStack.push(busyTime);
                }
                scn.close();
                break;
            } else {
                if (s == x) {
                    fullStack.push(dish);
                }
                if (t < startTime) {
                    dirtyStack.push(dish);
                } else if (t == startTime) {
                    dirtyStack.push(dish);
                    Dish temp = (Dish) dirtyStack.pop();
                    busyTime = startTime + a[temp.getCourse()] - 1;
                    startTime = busyTime + 1;
//                    System.out.println(busyTime);
                    cleanStack.push(temp);
                    endTimeStack.push(busyTime);
                } else {
                    while (dirtyStack.length() > 0 && t > startTime) {
                        Dish temp = (Dish) dirtyStack.pop();
                        busyTime = startTime + a[temp.getCourse()] - 1;
                        startTime = busyTime + 1;
//                        System.out.println(busyTime);
                        cleanStack.push(temp);
                        endTimeStack.push(busyTime);
                    }
                    if (startTime <= t) {
                        dirtyStack.push(dish);
                        Dish temp = (Dish) dirtyStack.pop();
                        startTime = t;
                        busyTime = startTime + a[temp.getCourse()] - 1;
                        startTime = busyTime + 1;
//                        System.out.println(busyTime);
                        cleanStack.push(temp);
                        endTimeStack.push(busyTime);
                    } else {
                        dirtyStack.push(dish);
                    }
                }
            }
        }
        System.out.println(endTimeStack.topValue());
        Integer[] endTime = new Integer[endTimeStack.length()];
        int index1 = 0;
        int index2 = 0;
        Dish[] fullMeal = new Dish[fullStack.length()];
        while (endTimeStack.length() > 0) {
            endTime[index1++] = (Integer) endTimeStack.pop();
        }
        for (int i = index1 - 1; i >= 0; i--) {
            if (i == index1 - 1) {
                System.out.print(endTime[i]);
            } else {
                System.out.print("," + endTime[i]);
            }
            endTimeStack.push(endTime[i]);
        }
        System.out.println("");
        if (fullStack.length() == n) {
            System.out.println("Y");
        } else {
            System.out.println("N");
        }
        while (fullStack.length() > 0) {
            fullMeal[index2++] = (Dish) fullStack.pop();
        }
        for (int i = index2 - 1; i >= 0; i--) {
            if (i == index2 - 1) {
                System.out.print(fullMeal[index2 - 1 - i].getFriend());
            } else {
                System.out.print("," + fullMeal[index2 - 1 - i].getFriend());
            }
            fullStack.push(fullMeal[index2 - 1 - i]);
        }
    }

    private static void OneArrTwoStackDishWasher() {
        Integer startTime = 0, busyTime = -1;
        Integer k, t, s;
        Scanner scn = new Scanner(System.in);
        Integer n, x;
        n = scn.nextInt();
        x = scn.nextInt();
        Dish[] arr = new Dish[n*x];
        ArrStack dirtyStack = new ArrStack(1,arr);
        ArrStack cleanStack = new ArrStack(-1,arr);
        ArrStack fullStack = new ArrStack(n);
        ArrStack endTimeStack = new ArrStack(n*x);
        Integer[] a = new Integer[x + 1];
        for (int i = 1; i <= x; i++) {
            a[i] = scn.nextInt();
        }
        while (true) {

            k = scn.nextInt();
            t = scn.nextInt();
            s = scn.nextInt();

            Dish dish = new Dish(k, t, s);

            if (k == 0) {
                while (dirtyStack.length() > 0) {
                    Dish temp = (Dish) dirtyStack.pop();
                    busyTime = startTime + a[temp.getCourse()] - 1;
                    startTime = busyTime + 1;
//                    System.out.println(busyTime);
                    cleanStack.push(temp);
                    endTimeStack.push(busyTime);
                }
                scn.close();
                break;
            } else {
                if (s == x) {
                    fullStack.push(dish);
                }
                if (t < startTime) {
                    dirtyStack.push(dish);
                } else if (t == startTime) {
                    dirtyStack.push(dish);
                    Dish temp = (Dish) dirtyStack.pop();
                    busyTime = startTime + a[temp.getCourse()] - 1;
                    startTime = busyTime + 1;
//                    System.out.println(busyTime);
                    cleanStack.push(temp);
                    endTimeStack.push(busyTime);
                } else {
                    while (dirtyStack.length() > 0 && t > startTime) {
                        Dish temp = (Dish) dirtyStack.pop();
                        busyTime = startTime + a[temp.getCourse()] - 1;
                        startTime = busyTime + 1;
//                        System.out.println(busyTime);
                        cleanStack.push(temp);
                        endTimeStack.push(busyTime);
                    }
                    if (startTime <= t) {
                        dirtyStack.push(dish);
                        Dish temp = (Dish) dirtyStack.pop();
                        startTime = t;
                        busyTime = startTime + a[temp.getCourse()] - 1;
                        startTime = busyTime + 1;
//                        System.out.println(busyTime);
                        cleanStack.push(temp);
                        endTimeStack.push(busyTime);
                    } else {
                        dirtyStack.push(dish);
                    }
                }
            }
        }
        System.out.println(endTimeStack.topValue());
        Integer[] endTime = new Integer[endTimeStack.length()];
        int index1 = 0;
        int index2 = 0;
        Dish[] fullMeal = new Dish[fullStack.length()];
        while (endTimeStack.length() > 0) {
            endTime[index1++] = (Integer) endTimeStack.pop();
        }
        for (int i = index1 - 1; i >= 0; i--) {
            if (i == index1 - 1) {
                System.out.print(endTime[i]);
            } else {
                System.out.print("," + endTime[i]);
            }
            endTimeStack.push(endTime[i]);
        }
        System.out.println("");
        if (fullStack.length() == n) {
            System.out.println("Y");
        } else {
            System.out.println("N");
        }
        while (fullStack.length() > 0) {
            fullMeal[index2++] = (Dish) fullStack.pop();
        }
        for (int i = index2 - 1; i >= 0; i--) {
            if (i == index2 - 1) {
                System.out.print(fullMeal[index2 - 1 - i].getFriend());
            } else {
                System.out.print("," + fullMeal[index2 - 1 - i].getFriend());
            }
            fullStack.push(fullMeal[index2 - 1 - i]);
        }
    }

    public static void main(String[] args) {
//        LLStackDishWasher();
//        ArrStackDishWasher();
        OneArrTwoStackDishWasher();
    }
}
