package br.ufrn.dimap.collaborativecanvas.gameservice.models;

public class HistoryDTO {
    private Long id;
    private int playerId;
    private int paintingId;

    private CanvaDTO canva;

    public HistoryDTO() {
    }

    public HistoryDTO(int playerId, int paintingId) {
        this.playerId = playerId;
        this.paintingId = paintingId;
    }

    public CanvaDTO getCanva() {
        return canva;
    }

    public void setCanva(CanvaDTO canva) {
        this.canva = canva;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public int getPaintingId() {
        return paintingId;
    }

    public void setPaintingId(int paintingId) {
        this.paintingId = paintingId;
    }


}
