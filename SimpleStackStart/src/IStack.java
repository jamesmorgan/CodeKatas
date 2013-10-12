public interface IStack{
     boolean isEmpty();
     int size();
     void add(Object item); //append item
     Object top(); //return first item, assert if empty
     void remove(); //remove first item, assert if empty
}
