package br.ufrn.dimap.collaborativecanvas.gameservice.models;


public class PaintingDTO {
    private long pixelId;
    private long playerId;
    private long canvaId;

    public PaintingDTO() {
    }

    public PaintingDTO(long pixelId, long playerId, long canvaId) {
        this.pixelId = pixelId;
        this.playerId = playerId;
        this.canvaId = canvaId;
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
