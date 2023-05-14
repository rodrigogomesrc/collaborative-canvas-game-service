package br.ufrn.dimap.collaborativecanvas.gameservice.models;

public class JogadaPlayerDTO {
    private long id;

    public JogadaPlayerDTO(long id) {
        this.id = id;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
