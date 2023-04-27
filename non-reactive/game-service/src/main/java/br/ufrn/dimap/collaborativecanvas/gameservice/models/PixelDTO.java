package br.ufrn.dimap.collaborativecanvas.gameservice.models;

public class PixelDTO {
    private Long id;
    private Integer x;
    private Integer y;
    private String color;
  
    private CanvaDTO canva;

    public PixelDTO() {
    }

    public PixelDTO(Integer x, Integer y, String color, CanvaDTO canva) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.canva = canva;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public CanvaDTO getCanva() {
        return canva;
    }

    public void setCanva(CanvaDTO canva) {
        this.canva = canva;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

}
