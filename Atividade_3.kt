fun main() {

    val nomeProduto: String = "Apple Iphone 15 Pro"
    val precoUnitario: Double = 8500.00
    val quantidadeComprada: Int = 20
    val taxaImposto: Double = 0.15  
    val margemLucro: Double = 0.20  

    println("\n Nome do Produto: $nomeProduto")
    println("\n Preço Unitário: R$ $precoUnitario")
    println("\n Quantidade Comprada: $quantidadeComprada")
    println("\n Taxa de Imposto: ${taxaImposto * 100}%")
    println("\n Margem de Lucro Desejada: ${margemLucro * 100}%")

    val totalSemImposto = precoUnitario * quantidadeComprada
    println("\n Total Sem Imposto: R$ $totalSemImposto")

    val totalComImposto = totalSemImposto * (1 + taxaImposto)
    println("\n Total Com Imposto: R$ $totalComImposto")


    val precoVenda = totalComImposto * (1 + margemLucro)
    println("\n Preço de Venda Necessário: R$ $precoVenda")
}
