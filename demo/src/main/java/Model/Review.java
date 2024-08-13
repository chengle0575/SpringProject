package Model;

public class Review {
    private int id;
    private String name;
    private String content;


    public Review(){

    }

    public int getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }

    public String getContent(){
        return this.content;
    }

    public void setId(int id){
        this.id=id;
    }

    public void setName(String name){
        this.name=name;
    }
    public void setContent(String content){
        this.content=content;
    }




    
}
