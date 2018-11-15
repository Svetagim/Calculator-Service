<?php
include 'class.php';
$calc = new Calc();
$calc->calculate(
    $calc->getFunc(),
    $calc->getNum1(),
    $calc->getNum2(),
    $calc->getNum3(),
    $calc->getNum4()
);
?>

