<html>
	<head>
		<meta charset="utf-8" />
    	<title>App Mail Send</title>

    	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	</head>
	<body>

		<div class="container">
			<div class="py-3 text-center">
				<img class="d-block mx-auto mb-2" src="logo.png" alt="" width="72" height="72">
				<h2>Send Mail</h2>
				<p class="lead">Seu app de envio de e-mails particular!</p>
			</div>
<?php

	require './PHPMailer/PHPMailer/Exception.php';
	require './PHPMailer/PHPMailer/OAuth.php';
	require './PHPMailer/PHPMailer/PHPMailer.php';
	require './PHPMailer/PHPMailer/POP3.php';
	require './PHPMailer/PHPMailer/SMTP.php';

	use PHPMailer\PHPMailer\PHPMailer;
	use PHPMailer\PHPMailer\Exception;

	//echo '<pre>';
	//print_r($_POST);
	//echo '</pre>';
	
	class Mensagem{

		private $para = null;
		private $assunto = null;
		private $mensagem = null;
		private $cPara = null;
	
		public $status = array('codigo_status'=>null, 'descricao_status'=>null);

		public function __get($atributo){
			return $this->$atributo;
		}

		public function __set($atributo, $valor){
			$this->$atributo = $valor;
		}

		public function mensagemValida(){

			if (empty($this->para)||empty($this->assunto) || empty($this->mensagem)){
				return false;
			}
			else {
				return true;
			}

		}
	}

	$mensagem = new Mensagem();
	$mensagem->__set('para', $_POST['para']);
	$mensagem->__set('assunto', $_POST['assunto']);
	$mensagem->__set('mensagem', $_POST['mensagem']);
	$mensagem->__set('cPara',$_POST['cPara']);

	if (!$mensagem->mensagemValida()){
		echo '
		<div class="row">
				<div class="col-md-12">
					<div class="container">
						<h1 class="display-4 text-danger">Ops!</h1>
						<p>Mensagem não é valida. Preencha todos os campos.</p>
						<a href="index.php" class="btn btn-danger btn-lg mt-5 text-white">Voltar</a>
					</div>
				</div>
			</div>';
		die(); // interrompe o processamento
		//header('location:index.php');
	}


	$mail = new PHPMailer(true);

	try {
	  
	    $mail->SMTPDebug = false;                
	    $mail->isSMTP();  
	    $mail->Host       = 'smtp.gmail.com';                   
	    $mail->SMTPAuth   = true;                                   
	    $mail->Username   = 'yuri.lombardi@aluno.ifsp.edu.br';                
	    $mail->Password   = 'xxdv glqw mgnk enqh';                               
	    $mail->SMTPSecure = PHPMailer::ENCRYPTION_STARTTLS;          
	    $mail->Port       = 587;                                    

	    //Recipients
	    $mail->setFrom('yuri.lombardi@aluno.ifsp.edu.br', 'Funcionario do Send Email');
	    $mail->addAddress($mensagem->__get('para'));     
	    //$mail->addReplyTo('info@example.com', 'Information');
	    $mail->addCC($mensagem->__get('cPara'));
	    //$mail->addBCC('bcc@example.com');

	    $mail->isHTML(true); 
	    $mail->Subject = $mensagem->__get('assunto');
	    $mail->Body    = $mensagem->__get('mensagem');
	    $mail->AltBody = 'This is the body in plain text for non-HTML mail clients';

	    $mail->send();
	    $mensagem->status['codigo_status'] = 1;
	    $mensagem->status['descricao_status'] = 'Email enviado com sucesso.';


	}catch (Exception $e) {
	    $mensagem->status['codigo_status'] = 2;
	    $mensagem->status['descricao_status'] = 'Erro ao enviar o email: '. $mail->ErrorInfo;
	}
?>
			<div class="row">
				<div class="col-md-12">

					<?php if ($mensagem->status['codigo_status'] == 1) { ?>                            
						<div class="container">
							<h1 class="display-4 text-success">Sucesso</h1>
							<p> <?=$mensagem->status['descricao_status']?> </p>
							<a href="index.php" class="btn btn-success btn-lg mt-5 text-white">Voltar</a>
						</div>
					<?php } ?>
					

					<?php if ($mensagem->status['codigo_status'] == 2) { ?>
						<div class="container">
							<h1 class="display-4 text-danger">Ops!</h1>
							<p><?=$mensagem->status['descricao_status']?></p>
							<a href="index.php" class="btn btn-danger btn-lg mt-5 text-white">Voltar</a>
						</div>
					<?php } ?>

				</div>
			</div>
		</div>

	</body>
</html>
