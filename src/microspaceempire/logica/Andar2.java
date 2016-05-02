package ficha5ex1paxa.logica;
public class Andar2 implements IEstados{
      
    
    @Override
    public IEstados up() {
            return this;
    }

    @Override
    public IEstados down(){
            return new Andar1();
    }
}
