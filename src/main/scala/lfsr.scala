
import chisel3._
import chisel3.util._

class lfsr extends Module {
  val io = IO(new Bundle {
    val enable = Input(Bool())
    val num1 = Output(UInt(32.W))
    val num2 = Output(UInt(32.W))
  })

 val lfsr = RegInit(1.U(32.W))
 val firstNum = RegInit(0.U(32.W))
 val secondNum = RegInit(0.U(32.W))

 val feedback = lfsr(31) ^ lfsr(21) ^ lfsr(1) ^ lfsr(0)

 when(io.enable){
    lfsr := Cat(lfsr(30,0),feedback)
    firstNum := lfsr
    secondNum := Cat(lfsr(30,0),feedback)
 }

 io.num1 := firstNum
 io.num2 := secondNum

}

object lfsrMain extends App {
  println("Generating the lfsr hardware")
  emitVerilog(new lfsr(), Array("--target-dir", "generated"))
}