fun main() {

    val nome: String = "João"
    var idade: Int = 19
    var salarioBruto: Double = 1500.00
    var mesesTrabalhados: Int = 11
    var produtosComprados: Int = 40
    var valorTotalGasto: Double = 1000.00
    val descontoAnual: Double = 1540.00

    println("\n --- Informação do Colaborador ---")
    println("Nome: $nome")
    println("Idade: $idade")
    println("Salário Bruto: R$ $salarioBruto")
    println("Meses Trabalhados: $mesesTrabalhados")
    println("Produtos Comprados: $produtosComprados")

    val salarioMensal = salarioBruto / mesesTrabalhados
    println("\n Salário Mensal Ajustado: R$ $salarioMensal")

    val salarioAnualBruto = salarioBruto * mesesTrabalhados
    println("\n Salário Anual Bruto: R$ $salarioAnualBruto")

    val salarioAnualLiquido = salarioAnualBruto - descontoAnual
    println("\nSalário Anual Líquido: R$ $salarioAnualLiquido")

    val mediaGastoPorProduto = valorTotalGasto / produtosComprados
    println("\nMédia de Gasto por Produto: R$ $mediaGastoPorProduto")

    val mensagemFinal = "\n Olá, $nome! \n Seu salário anual líquido é de R$ $salarioAnualLiquido. \n Continue trabalhando!"
    println(mensagemFinal)
}
