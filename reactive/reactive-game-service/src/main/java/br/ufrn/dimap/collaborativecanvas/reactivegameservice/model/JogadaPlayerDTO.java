package br.ufrn.dimap.collaborativecanvas.reactivegameservice.model;

public class JogadaPlayerDTO {
    private Long id;

    public JogadaPlayerDTO(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
