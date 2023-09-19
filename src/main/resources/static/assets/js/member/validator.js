class Validator {
  /**
   * 문자열 입력 여부
   * @param {string} 입력 문자열 
   * @returns 문자열 입력 여부
   */
  static hasText(value) {
    if (value === undefined || value.length === 0) {
      return false;
    } 
    return true;
  }
  
  /**
   * 아이디 사용 가능 여부
   * @param {string} 입력 아이디 
   * @returns 아이디 사용 가능 여부
   */
  static isId(value) {
	const exp = /^[a-zA-Z][0-9a-zA-Z]{5,12}$/g;
	return exp.test(value);
	}
	
   /**
   * 비밀번호 사용 가능 여부
   * @param {string} 입력 아이디 
   * @returns 비밀번호 사용 가능 여부
   */
  static isPw(value) {
	const exp = /^[A-Za-z0-9`~!@#\$%\^&\*\(\)\{\}\[\]\-_=\+\\|;:'"<>,\./\?]{4,16}$/;
	return exp.test(value);
	}

  /**
   * 숫자 입력 여부
   * @param {string} 입력 문자열 
   * @returns 숫자 여부
   */
  static isNumber(value) {
    let RegExp = /^[0-9]*$/;
    if (!RegExp.test(value)) {
      return false;
    } 
    return true;
  }

  /**
   * 이름 입력 여부
   * @param {string} 입력 문자열 
   * @returns 이름 입력 여부
   */
  static isName(value) {
    let RegExp =  /^[가-힣a-zA-Z]+$/;
    if (!RegExp.test(value)) {
      return false;
    } else if (value.length < 2 || value.length > 10) {
      return false;
    }
    return true;
  }

  /**
   * 숫자 입력 여부
   * @param {number} value 
   * @returns 숫자 입력 여부
   */
  static isScore(value) {
    let RegExp = /^[0-9]*$/;
    if (!RegExp.test(value)) {
      return false;
    } else if (value < 0 || value > 100) {
      return false;
    }
    return true;
  }
  
  /**
   * 전화번호 입력 여부
   */
  static isPhoneNum(value){
	  let RegExp = /^[0-9]{2,3}-[0-9]{3,4}-[0-9]{4}/;
	  if(!RegExp.test(value)) {
		  return false;
	  }
	  return true;  
  }
  
   /**
   * 이메일 입력 여부
   */
  static isEmail(value){
	  let RegExp = /^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$/;
	  if(!RegExp.test(value)) {
		  return false;
	  }
	  return true;  
  }
  
   /**
   * 생년월일 입력 여부
   */
  static isBirthday(value){
	  let RegExp = /^[0-9]{4}-[0-9]{1,}-[0-9]{1,}/;
	  if(!RegExp.test(value)) {
		  return false;
	  }
	  return true;  
  }
  
   /**
   * 주소 입력 여부
   */
  static isAdress(value){
	  let RegExp = /^[가-힣a-zA-Z0-9\s\(\)\-]+$/;
	  if(!RegExp.test(value)) {
		  return false;
	  }
	  return true;
  }
  
}
