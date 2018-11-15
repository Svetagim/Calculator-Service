<?php
class ReadParameters
{
    private  $num1;
    private  $num2;
    private  $num3;
    private  $num4;
    private  $func;
    public function __construct(){}
    public function __destruct(){}
    public function getNum1(){return $this->num1;}
    public function getNum2(){return $this->num2;}
    public function getNum3(){return $this->num3;}
    public function getNum4(){return $this->num4;}
    public function getFunc(){return $this->func;}

    public function readp(){
        if ($_SERVER['REQUEST_METHOD'] == 'POST') {
            $this->num1 = (int)$_POST["num1"];
            $this->num2 = (int)$_POST["num2"];
            $this->num3 = (int)$_POST["num3"];
            $this->num4 = (int)$_POST["num4"];
            $this->func = $_POST["func"];
        }
        elseif ($_SERVER['REQUEST_METHOD'] == 'GET') {
            $this->num1 = (int)$_GET["num1"];
            $this->num2 = (int)$_GET["num2"];
            $this->num3 = (int)$_GET["num3"];
            $this->num4 = (int)$_GET["num4"];
            $this->func = $_GET["func"];
        }
        elseif ($_SERVER['REQUEST_METHOD'] == 'PUT') {
            parse_str(file_get_contents("php://input"),$post_vars);
            $this->num1 = (int)$post_vars["num1"];
            $this->num2 = (int)$post_vars["num2"];
            $this->num3 = (int)$post_vars["num3"];
            $this->num4 = (int)$post_vars["num4"];
            $this->func = $post_vars["func"];
        }
        else {
            http_response_code(500);
            die("Bad request");
        }
    }
}
class Calc extends ReadParameters
{
     private $a;
     private $res;
     public function __construct(){$this->readp();}
     public function __destruct(){}
     public function calculate($func,$num1=0,$num2=0,$num3=0,$num4=0){
     switch ($func){
         case "sum":
             $this->res=$num1 + $num2 + $num3 + $num4;
             break;
         case "avg":
             $this->res=($num1 + $num2 + $num3 + $num4)/4;
             break;
         case "mult":
             $this->res=$num1 * $num2 * $num3 * $num4;
             break;
         defult:
             print('Error!');
     }
     $this->a = array('retVal' => $this->res); // build the results Array
     header('Content-Type: application/json'); // set header for json response
     echo json_encode($this->a); // echo the converted JSON Object from the Array

 }
}
?>