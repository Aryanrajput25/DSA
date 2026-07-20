class Solution {
    public int secondsBetweenTimes(String startTime, String endTime) {
        int starthour=Integer.parseInt(startTime.substring(0,2));
        int startmin=Integer.parseInt(startTime.substring(3,5));
        int startsec=Integer.parseInt(startTime.substring(6,8));
        int endhour=Integer.parseInt(endTime.substring(0,2));
        int endmin=Integer.parseInt(endTime.substring(3,5));
        int endsec=Integer.parseInt(endTime.substring(6,8));
        int diffhour=endhour-starthour;
        int diffmin=endmin-startmin;
        int diffsec=endsec-startsec;
        return diffhour*3600+diffmin*60+diffsec;
    }
}