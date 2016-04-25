import org.scalatest.{BeforeAndAfter, FunSuite}
import xebia.homework._

import scala.collection.mutable.ListBuffer

class TondeuseServiceTest extends FunSuite with BeforeAndAfter{


  case class F(startTondeusePosition: Tondeuse, borne: Position, instructions: String, finalDestination: Tondeuse)

  val list = List(F(Tondeuse(Position(1,2),Direction.N), Position(5,5) , "GAGAGAGAA", Tondeuse(Position(1,3),Direction.N)),
                  F(Tondeuse(Position(3,3),Direction.E), Position(5,5) , "AADAADADDA", Tondeuse(Position(5,1),Direction.E)),
                  F(Tondeuse(Position(0,0),Direction.S), Position(5,5) , "DAAGAAGAA", Tondeuse(Position(2,0),Direction.E)))


  test("test moveOnSuequence") {
    list.foreach(f => {
      assert(TondeuseService().moveOnSequence(f.startTondeusePosition, f.borne, f.instructions) === f.finalDestination)
    })
    info("moveOnsequence seems to work on data list")
  }







}
