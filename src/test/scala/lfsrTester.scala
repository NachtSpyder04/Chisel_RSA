/*
 * Dummy tester to start a Chisel project.
 *
 * Author: Martin Schoeberl (martin@jopdesign.com)
 * 
 */



import chisel3._
import chiseltest._
import org.scalatest.flatspec.AnyFlatSpec

class lfsrTester extends AnyFlatSpec with ChiselScalatestTester {

  "lfsr" should "work" in {
    test(new lfsr). withAnnotations (Seq( WriteVcdAnnotation)) { dut =>
      for (a <- 0 to 5) { 
          dut.io.enable.poke(1.U)
          dut.clock.step(1)

       
      }
    }
  }
}
