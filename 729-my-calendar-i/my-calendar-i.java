class Pair{
    int start;
    int end;

    Pair(int start, int end){
        this.start = start;
        this.end = end;
    }
}

class MyCalendar {
    List<Pair> list = new ArrayList<>();

    public MyCalendar() {}
    
    public boolean book(int startTime, int endTime) {
        for(Pair p : list){
            //overlap
            if(p.start<endTime && p.end>startTime)return false;
        }
        list.add(new Pair(startTime,endTime));
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */