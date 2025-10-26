package com.juanpirir.catalogoapp.entidad;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "archivos_multimedia")
public class ArchivoMultimedia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "titulo_id", nullable = false)
    private Titulo titulo;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_archivo", length = 20, nullable = false)
    private TipoArchivo tipoArchivo;

    @NotNull
    @Column(name = "url_blob", length = 500, nullable = false)
    private String urlBlob;

    @Column(name = "etag", length = 100)
    private String etag;

    @Column(name = "tipo_contenido", length = 50)
    private String tipoContenido;

    @Column(name = "tamano_bytes")
    private Long tamanoBytes;

    @Column(name = "fecha_subida", nullable = false)
    private LocalDateTime fechaSubida;

    @Column(name = "subido_por", length = 50)
    private String subidoPor;

    @PrePersist
    public void prePersist() {
        this.fechaSubida = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Titulo getTitulo() { return titulo; }
    public void setTitulo(Titulo titulo) { this.titulo = titulo; }

    public TipoArchivo getTipoArchivo() { return tipoArchivo; }
    public void setTipoArchivo(TipoArchivo tipoArchivo) { this.tipoArchivo = tipoArchivo; }

    public String getUrlBlob() { return urlBlob; }
    public void setUrlBlob(String urlBlob) { this.urlBlob = urlBlob; }

    public String getEtag() { return etag; }
    public void setEtag(String etag) { this.etag = etag; }

    public String getTipoContenido() { return tipoContenido; }
    public void setTipoContenido(String tipoContenido) { this.tipoContenido = tipoContenido; }

    public Long getTamanoBytes() { return tamanoBytes; }
    public void setTamanoBytes(Long tamanoBytes) { this.tamanoBytes = tamanoBytes; }

    public LocalDateTime getFechaSubida() { return fechaSubida; }
    public void setFechaSubida(LocalDateTime fechaSubida) { this.fechaSubida = fechaSubida; }

    public String getSubidoPor() { return subidoPor; }
    public void setSubidoPor(String subidoPor) { this.subidoPor = subidoPor; }
}
