	INSERT INTO public.tb_pedido(
	momento_pedido, status_pedido, pedidopessoa_id)
	VALUES ( '2023-06-04 19:24'::timestamp, 1, 2);
	
	SELECT * FROM public.tb_pedido;
	
	INSERT INTO public.tb_item_pedido(
	preco, quantidade, produto_id, pedido_id)
	VALUES ( 10, 1, 1, 1);
	
	INSERT INTO public.tb_pagamento(
	momento_pago, pedido_id)
	VALUES ( '2023-06-04 19:24'::timestamp,1);

	INSERT INTO public.tb_pedido(
	momento_pedido, status_pedido, pedidopessoa_id)
	VALUES ( '2023-06-04 20:45'::timestamp, 1, 2);
	
	SELECT * FROM public.tb_pedido;
	
	INSERT INTO public.tb_item_pedido(
	preco, quantidade, produto_id, pedido_id)
	VALUES ( 5, 2, 1, 3);
	
	INSERT INTO public.tb_pagamento(
	momento_pago, pedido_id)
	VALUES ( '2023-06-04 20:45'::timestamp,3);