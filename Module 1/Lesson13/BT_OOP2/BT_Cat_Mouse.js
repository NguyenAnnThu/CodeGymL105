class Rat{
    status;
    sound_mouse;
    constructor(name,weight_mouse,speed_mouse){
        this.name=name;
        this.weight=weight_mouse;
        this.speed=speed_mouse;
        this.status=true
    }
    getStatus(){
        if(this.status){
            return "Chuột còn sống"
        }
        else{
            return "Chuột đã bị mèo bắt được "
        }
    }
    Die(){
        return this.status=false;
    }
    noDie(){
        return this.status=true
    }
    Sound(sound_mouse){
        this.sound_mouse=sound_mouse;
        alert(this.sound_mouse);
    }
}
class Cat{
    sound_cat;
    constructor(name,weight_cat,speed_cat,mouse){
        this.name=name;
        this.weight_cat=weight_cat;
        this.speed_cat=speed_cat;
        this.mouse=mouse;
    }
   getWeight(){
        return this.weight_cat;
   }
   setSound(sound_cat){
        this.sound_cat=sound_cat;
   }
   getSound(){
        return this.sound_cat;
   }
   actionCat(sound){
        this.sound_cat=sound;
        alert(this.sound_cat);
   }
   CatTheMouse(){
        if(this.mouse.speed< this.speed_cat){
            return("Chuột đã bị bắt")
        }
        else{
            return "Chuột đã chạy thoát"
        }
   }
   CateatMouse(){
        if(this.mouse.status){
            this.weight_cat=this.weight_cat+this.mouse.weight
            this.mouse.status=false;
            alert("Chuột đã bị mèo ăn")
        }
   }
}
let mouse=new Rat("Rat",10,100);
let Tom=new Cat("Tom",20,200,mouse);
mouse.noDie();
Tom.CatTheMouse()
Tom.CateatMouse();
console.log(Tom.getWeight())