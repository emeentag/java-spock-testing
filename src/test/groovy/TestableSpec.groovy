import spock.lang.Specification
import spock.lang.Unroll

class TestableSpec extends Specification {
  
  @Unroll
  def 'getName should return Serdar'() {
    given: 'create testable instance'
    Testable testable = new Testable()
    
    when: 'call getName'
    String result = testable.getName()
    
    then: 'check result'
    result == "Serdar"
  }
  
  @Unroll
  def 'multiplyIntegers should return mutiplied integers'() {
    given:
    Testable testable = new Testable()
    
    when:
    Integer result = testable.multiplyIntegers(inputFirstInteger, inputSecondInteger)
    
    then:
    result == expectedResult
    
    where:
    inputFirstInteger | inputSecondInteger || expectedResult
    2                 | 3                  || 6
    0                 | 1                  || 0
    1                 | 0                  || 0
    30                | 30                 || 900
  }
  
  @Unroll
  def 'mockFunction should return mocked value'() {
    given: 'assign a value to the mockFunction'
    Testable mockTestable = Mock(Testable)
    mockTestable.mockFunction(_) >> inputMockValue
    
    when: 'call mockFunction with any parameter and should return inputMockValue'
    Integer result = mockTestable.mockFunction(null)
    
    then: 'result should always equal to the inputMockValue'
    result == expectedResult
    
    where:
    inputMockValue || expectedResult
    2              || 2
    100            || 100
    -99            || -99
  }
}
