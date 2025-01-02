<?php
//Feito por:Yuri e Kevin
//Data: 22/10/24
    class Cliente{
        public $cod = null;
        public $nome = null;
        public $cidade = null;

        function __construct($cod,$nome,$cidade){
            $this->cod = $cod;
            $this->nome = $nome;
            $this->cidade = $cidade;
        }
        function __set($atributo , $valor){
            $this-> $atributo = $valor;
        }
        function __get($atributo){
            return $this -> $atributo;
        }
        function resumirCliente(){
            return "
            <table border = '1'>
                <tr>
                    <th>Código</th>
                    <th>Nome</th>
                    <th>Cidade</th>
                </tr>
                    <td>$this->cod</td>
                    <td>$this->nome</td>
                    <td>$this->cidade</td>
                </tr>
            </table>";
        }
        function __destruct(){
            echo "Objeto destruído<br>";
        }
    }
    $cliente1 = new Cliente(1234,'Paulo','Nova Odessa');
    $cliente2 = new Cliente(4567,'Jorge','Cabreuva');
    echo "Dados do cliente 1:<br>".$cliente1 ->resumirCliente();
    echo "<br>";
    unset($cliente1);
    echo "<br>";
    echo "Dados do cliente 2:<br>".$cliente2 ->resumirCliente();
    echo "<br>";
    unset($cliente2);
?>