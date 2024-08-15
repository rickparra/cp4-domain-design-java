package teste;

import principal.Pessoa;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Criação de pessoas para o teste
        Pessoa pessoa1 = new Pessoa("Parra", 9, "RG123");
        Pessoa pessoa2 = new Pessoa("Ana", 25, "RG456");
        Pessoa pessoa3 = new Pessoa("João", 30, "RG123"); // Documento duplicado

        // Criação de uma lista de pessoas
        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(pessoa1);
        pessoas.add(pessoa2);
        pessoas.add(pessoa3);

        // Teste: Adicionando e retornando lista de pessoas
        List<Pessoa> listaComPessoaAdicionada = adicionarPessoaNaLista(pessoas, new Pessoa("Maria", 22, "RG789"));
        System.out.println("Lista após adicionar nova pessoa:");
        listaComPessoaAdicionada.forEach(System.out::println);

        // Teste: Removendo duplicados
        List<Pessoa> listaSemDuplicados = removerDuplicados(listaComPessoaAdicionada);
        System.out.println("\nLista sem duplicados:");
        listaSemDuplicados.forEach(System.out::println);

        // Teste: Adicionando pessoa no mapa e obtendo-a
        Map<String, Pessoa> mapaPessoas = new HashMap<>();
        adicionarPessoaNoMapa(mapaPessoas, pessoa1);
        Pessoa pessoaObtida = obterPessoaDoMapa(mapaPessoas, "RG123");
        System.out.println("\nPessoa obtida do mapa:");
        System.out.println(pessoaObtida);

        // Teste: Ordenação
        List<Pessoa> listaOrdenadaCrescente = ordenarLista(listaSemDuplicados, true);
        System.out.println("\nLista ordenada em ordem crescente:");
        listaOrdenadaCrescente.forEach(System.out::println);

        List<Pessoa> listaOrdenadaDecrescente = ordenarLista(listaSemDuplicados, false);
        System.out.println("\nLista ordenada em ordem decrescente:");
        listaOrdenadaDecrescente.forEach(System.out::println);
    }

    // Método para adicionar uma pessoa em uma lista e retornar a lista
    public static List<Pessoa> adicionarPessoaNaLista(List<Pessoa> lista, Pessoa pessoa) {
        lista.add(pessoa);
        return lista;
    }

    // Método para remover duplicados da lista
    public static List<Pessoa> removerDuplicados(List<Pessoa> lista) {
        Set<Pessoa> set = new HashSet<>(lista);
        return new ArrayList<>(set);
    }

    // Método para adicionar uma pessoa em um mapa
    public static void adicionarPessoaNoMapa(Map<String, Pessoa> mapa, Pessoa pessoa) {
        mapa.put(pessoa.getDocumento(), pessoa);
    }

    // Método para obter uma pessoa do mapa
    public static Pessoa obterPessoaDoMapa(Map<String, Pessoa> mapa, String documento) {
        return mapa.get(documento);
    }

    // Método para ordenar a lista
    public static List<Pessoa> ordenarLista(List<Pessoa> lista, boolean crescente) {
        lista.sort(Comparator.comparingInt(Pessoa::getIdade));
        if (!crescente) {
            Collections.reverse(lista);
        }
        return lista;
    }
}
