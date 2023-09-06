    package br.edu.ufape.poo.barbeariaufape.negocio.basica;

    import java.math.BigDecimal;

    import jakarta.persistence.Entity;
    import jakarta.persistence.GeneratedValue;
    import jakarta.persistence.GenerationType;
    import jakarta.persistence.Id;

    @Entity
    public class Produto {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String nome;
        private BigDecimal preco;
        private String descricao;
        private BigDecimal quantidade;

        public Produto() {
        }

        public Produto(String nome, BigDecimal preco, String produto, BigDecimal quantidade) {
            this.nome = nome;
            this.preco = preco;
            this.descricao = produto;
            this.quantidade = quantidade;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public BigDecimal getPreco() {
            return preco;
        }

        public void setPreco(BigDecimal preco) {
            this.preco = preco;
        }

        public String getDescricao() {
            return descricao;
        }

        public void setDescricao(String descricao) {
            this.descricao = descricao;
        }

        public BigDecimal getQuantidade() {
            return quantidade;
        }

        public void setQuantidade(BigDecimal quantidade) {
            this.quantidade = quantidade;
        }

        @Override
        public String toString() {
            return "Produto [id=" + id + ", nome=" + nome + ", preco=" + preco + "]";
        }
    }