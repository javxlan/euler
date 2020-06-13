package leetcode.april;

class StudentAttendance {

    public static void main(String[] args) {
        StudentAttendance s = new StudentAttendance();
        System.out.println(s.checkRecord("ALLAPPL"));
    }

    public boolean checkRecord(String s) {

        if (checkDoubleLL(s)) return false;
        int AbsentCount = 0;
        char[] att = s.toCharArray();

        boolean result = true;

        for (char c : att) {
            if (c == 'A') {
                AbsentCount++;
                if (AbsentCount == 2) {
                    result = false;
                    break;
                }
            }
        }

        return result;
    }

    public boolean checkDoubleLL(String s) {
        return s.indexOf("LLL") == -1 ? false : true;
    }

}
