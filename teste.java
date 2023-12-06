Interface app = new Interface();
		ArrayList<Cliente> cliente = new ArrayList<Cliente>();
		ArrayList<Fatura> fatura = new ArrayList<Fatura>();
		ArrayList<Imovel> imovel = new ArrayList<Imovel>();
		ArrayList<String> lista_opcoes = new ArrayList<String>(
				List.of("Clientes", "Imóveis", "Faturas", "Pagamentos", "Falhas"));
		int opcao_usuario = 1;
		String nome, email;
		Scanner entrada = new Scanner(System.in);

		Cliente a = new Cliente("123.456.789-10", "Arthur");
		Cliente b = new Cliente("123.456.789-20", "Nathalie");
		Cliente c = new Cliente("123.456.789-30", "Leane");

		while (opcao_usuario != 0) {
			Interface.montarMenu("principal", lista_opcoes);
			System.out.print("\nSua opção: ");
			opcao_usuario = entrada.nextInt();

			switch (opcao_usuario) {
				case 0:
					System.out.println("Fim do programa!");
					break;

				case 1:
					app.gestaoClientes();
					break;

				case 2:
					app.gestaoImoveis();
					break;

				case 3:
					app.gestaoFaturas();
					break;

				case 4:
					app.gestaoPagamentos();
					break;

				case 5:
					app.gestaoFalhas();
					break;

				default:
					Interface.mostrarMensagemDefault(lista_opcoes);
					break;