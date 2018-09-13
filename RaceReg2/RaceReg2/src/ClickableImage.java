
import java.awt.event.MouseEvent;
import java.awt.event.*;
public abstract class ClickableImage extends EzImage implements MouseListener{
    protected int count;
    public ClickableImage(int x, int y, int w, int h, String s){
        super(x,y,w,h);
        count = 0;
        super.setImage(s);
        addMouseListener(this);
        setVisible(true);
    }

    public ClickableImage(int x, int y, String s){
        super(x,y,100,100);
        count = 0;
        super.setImage(s);
    }
    
    public abstract void mouseClicked(MouseEvent e);
   
    public void mouseExited(MouseEvent e){}

    public void mousePressed(MouseEvent e){}

    public void mouseEntered(MouseEvent e){}

    public void mouseReleased(MouseEvent e){}
}
