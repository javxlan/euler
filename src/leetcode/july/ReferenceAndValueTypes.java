package leetcode.july;

public class ReferenceAndValueTypes {
    public static void main(String[] args) {
        /***
         * Value types
         * byte, short, int, long, float, double, boolean , char
         */

        int x = 5;

        addOneTo(x);

        System.out.println(x);


        /***
         * Reference types
         * Object , Class , Custom defined types
         * Person john = new Person();
         * john.setAge(20);
         * celebrateBirthday(john) //age  increment by 1 year
         * System.out.println(john.getAge()) = 21
         */
    }

    static void addOneTo(int number) {
        number = number + 1;
    }
}
