package br.ufrn.dimap.collaborativecanvas.gameservice.models;


public class PaintingDTO {
    private long pixelId;
    private long playerId;
    private long canvaId;
    private String color;

    public PaintingDTO() {
    }

    public PaintingDTO(long pixelId, long playerId, long canvaId, String color) {
        this.pixelId = pixelId;
        this.playerId = playerId;
        this.canvaId = canvaId;
        this.color = color;
    }

    public String getcolor() {
        return this.color;
    }

    public void setPixel(String color) {
        this.color = color;
    }

    public long getPixelId() {
        return this.pixelId;
    }

    public void setPixel(long pixelId) {
        this.pixelId = pixelId;
    }

    public long getPlayerId() {
        return this.playerId;
    }

    public void setPlayerId(long playerId) {
        this.playerId = playerId;
    }

    public long getCanvaId() {
        return this.canvaId;
    }

    public void setCanvaId(long canvaId) {
        this.canvaId = canvaId;
    }
}
