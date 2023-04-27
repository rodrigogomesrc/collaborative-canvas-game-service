package br.ufrn.dimap.collaborativecanvas.gameservice.models;


public class PaintingDTO {
    private long id;
    private long pixel;
    private long playerId;
    private long canvaId;

    public PaintingDTO() {
    }

    public PaintingDTO(long id, long pixelId, long playerId, long canvaId) {
        this.id = id;
        this.pixel = pixelId;
        this.playerId = playerId;
        this.canvaId = canvaId;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPixel() {
        return this.pixel;
    }

    public void setPixel(long pixel) {
        this.pixel = pixel;
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
