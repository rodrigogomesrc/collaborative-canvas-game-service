package br.ufrn.dimap.collaborativecanvas.gameservice.models;

public class JogadaCanvaDTO {
    private Long pixelId;
    private Long playerId;
    private Long canvasId;
    private String color;

    public JogadaCanvaDTO(Long pixelId, Long playerId, Long canvasId, String color) {
        this.pixelId = pixelId;
        this.playerId = playerId;
        this.canvasId = canvasId;
        this.color = color;
    }

    public Long getPixelId() {
        return this.pixelId;
    }

    public void setPixelId(Long pixelId) {
        this.pixelId = pixelId;
    }

    public Long getPlayerId() {
        return this.playerId;
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }

    public Long getCanvasId() {
        return this.canvasId;
    }

    public void setCanvasId(Long canvasId) {
        this.canvasId = canvasId;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }


}
