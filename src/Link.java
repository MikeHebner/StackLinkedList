public class Link {
    public long dData;             // data item
    public Link next;              // next link in list
    public Link(long dd){           // constructor
        dData = dd;
    }
    public void displayLink(){      // display ourselves
        System.out.print(dData + " ");
    }

}
