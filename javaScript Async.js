    const calcularMultiplicacion = empanadasActuales => {
        let promise, multiplicacion = 2 * 5;
        return promise = new Promise(resolve => resolve(multiplicacion));
    };

  let multiplicacion = 0;
  
  
  async function calcularOperacion(){
      try{
          const operacion1 = await calcularMultiplicacion(multiplicacion);
          console.log("Resultado", operacion1);
      } catch(e){
          throw "Error: ${e}";
        }
  }
  calcularOperacion());