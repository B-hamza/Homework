
import org.scalatest._
import xebia.homework.{Direction, Position, Tondeuse}


class TondeuseTest extends FunSuite with BeforeAndAfter{

  case class F(start: Tondeuse, finish: Tondeuse)
  val listMoves = List(F(Tondeuse(Position(1,1), Direction.N), Tondeuse(Position(1,2), Direction.N)),
                      F(Tondeuse(Position(1,1), Direction.E), Tondeuse(Position(2,1), Direction.E)),
                      F(Tondeuse(Position(1,1), Direction.S), Tondeuse(Position(1,0), Direction.S)),
                      F(Tondeuse(Position(1,1), Direction.W), Tondeuse(Position(0,1), Direction.W)))

  test("move") {
    listMoves.foreach(f => {
      assert(f.start.move() === f.finish)
    })
    info("move Tondeuse seems to work")
  }

  test("oriente") {
    assert(Tondeuse(Position(0, 0), Direction.N).oriente('D') === Tondeuse(Position(0, 0), Direction.E))
    assert(Tondeuse(Position(1, 1), Direction.N).oriente('G') === Tondeuse(Position(1, 1), Direction.W))

    assert(Tondeuse(Position(0, 0), Direction.E).oriente('D') === Tondeuse(Position(0, 0), Direction.S))
    assert(Tondeuse(Position(1, 1), Direction.E).oriente('G') === Tondeuse(Position(1, 1), Direction.N))

    assert(Tondeuse(Position(0, 0), Direction.S).oriente('D') === Tondeuse(Position(0, 0), Direction.W))
    assert(Tondeuse(Position(1, 1), Direction.S).oriente('G') === Tondeuse(Position(1, 1), Direction.E))

    assert(Tondeuse(Position(0, 0), Direction.W).oriente('D') === Tondeuse(Position(0, 0), Direction.N))
    assert(Tondeuse(Position(1, 1), Direction.W).oriente('G') === Tondeuse(Position(1, 1), Direction.S))

    info("oriente Tondeuse seems to work")
  }


}
