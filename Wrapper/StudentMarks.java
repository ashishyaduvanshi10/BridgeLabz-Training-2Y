public class StudentMarks {
    public static void main(String[] args) {
        Object[] marks = {"85", 95, Integer.valueOf(88), "null", "abc"};

        int total = 0, count = 0;

        for (Object m : marks) {
            try {
                Integer mark = null;

                if (m instanceof String) {
                    String str = (String) m;
                    if (!str.equalsIgnoreCase("null"))
                        mark = Integer.parseInt(str);
                } else if (m instanceof Integer) {
                    mark = (Integer) m;
                }

                if (mark != null) {
                    total += mark;
                    count++;
                }

            } catch (NumberFormatException e) {
                System.out.println("Invalid mark skipped: " + m);
            }
        }

        double average = count > 0 ? (double) total / count : 0;
        System.out.println("Average mark: " + average);
    }
}
