class Solution {
    public String reformatDate(String date) {
        String[] d = date.split(" "); // length = 3
        StringBuilder s = new StringBuilder();

        for (int i = 2; i >= 0; i--) {
            if (i == 2)
                s.append(d[i]).append("-");
            if (i == 1)
                s.append(index(d[i])).append("-");
            if (i == 0) {
                if (d[0].length() == 3) {
                    s.append("0").append(d[0].charAt(0));
                } else {
                    s.append(d[0].charAt(0));
                    s.append(d[0].charAt(1));
                }
            }
        }
        return s.toString();
    }

    public String index(String t) {
        String[] month = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

        for (int i = 0; i <= 11; i++) {
            if (t.equals(month[i])) {
                if(i<9) return ("0"+(i+1)+"");
                else return (i+1+"");
            }
        }
        return "";
    }
}