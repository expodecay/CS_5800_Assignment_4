package Flyweight;

import java.awt.*;

public class FlyWeight {
    String text;
    String font;
    Color color;
    int size;

    public FlyWeight(String _text, String _font, Color _color, int _size){
        text = _text;
        font = _font;
        color = _color;
        size = _size;
    }

    public String getText(){
        return text;
    }
    public String getFont(){
        return font;
    }
    public Color getColor(){
        return color;
    }
    public int getSize(){
        return size;
    }

    public boolean isSame(FlyWeight object){
        return (text.equalsIgnoreCase(object.text) && font.equalsIgnoreCase(object.font) && color.equals(object.color) && size==object.size);
    }
}
