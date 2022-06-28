**Editor** : _VScode_ 

**INPUT**
_1)The inputParser class takes Path, and returns List<Integer> of currentSpeeds._

**Throttle Controller Implementation**
_1)We use setCruiseSpeed() to assign value to cruiseSpeed._
_2)The currentSpeed is passed to throttleControllerImpl class, which use interface Quantize<T> to calculate the current ThrottleLevel._
_3) **Assumptions**_
        1) In the cruiseMode, we will maintain speed at cruiseSpeed. 
        2) If currentSpeed != cruiseSpeed. Then we can setCruiseSpeed to currentSpeed. Or else we can setCruiseSpeed to NULL.
        3) We can use the existing setCruiseSpeed to assign any of above values.
_4) Here we can set the setRange() in Quantizer Implementation, by default it will be 2._

**Quantizer Implementation**
_1)It is of generic type. QuantizerImpl<Integer> is implementation of Quantizer<T>._
_2)It has setRange() method to set the range for our hysteresis._
_3)It also has SetPreviousThrottle(), SetPreviousSpeed() to maintain data from previously executed Input/Speed._
_4)It contains IsInRange() to check if currentSpeed in the bounds of [previousSpeed-range, previousSpeed+range]._
_5).The qunatize() just returns the throttleLevel, by using getThrottleLevel._

**_Running_**
_1)./gradlew test (--info): For executing all our Test Cases, run along with --info for additional information._
_2)./gradlew build : For executing our overall application, run along with --info for additional information._




