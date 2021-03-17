Caso de uso RiddleOnstage(ApostarEnEtapa)
En esta parte se ponen las apuestas de cada jugador en el stage tanto de las caras como 
de las repeticiones y tambien el monto que desea apostar este no debe ser mayor a la 
cantidad maxima de saldo actual de otro jugador este caso de uso sucede cuando se inicia el
primer stage(etapa) 

caso de uso AumentToBet(AumentarApuestaEtapa)
Este caso de uso sucede cuando un jugador quiere aumentar la apuesta que hizo otro jugador
este aumento no puede ser mayor a la cantidad maxima de saldo actual de otro jugador

Caso de uso ShowDiceFace(MostrarCaraDelDado)
este caso va a ser llamado cuando se requieran mostrar las caras del dado oculto, el la 
primer etapa se mostraran 3 caras , si los jugadores llegan a la segunda etapa y apostaron
en esta se mostraran 2 caras y en al ultima se mostrara solo 1 despues de que los jugadores 
hicieran sus apuestas 

caso uso DeclineOnStage(RetirarDeLaEtapa)
Este caso de uso sucede si un jugador se quiere retirar del Stage.
este puede ser activado en cualquier parte del stage

caso de uso AllingStage(ApuestoTodoEtapa)
Este caso sucede cuando un jugador quiere apostar todo su saldo ya que no tiene mas y 
quiere lanzar su apuesta, los otros ya deciden si la igualan o se retiran 
este se puede activar en cualquier stage



caso de uso CompareRiddleOnStage(CompararApuestaEnEtapa)
En este caso de uso lo que se hace es comparar las apuestas de los jugadores con los dados 
que han sido revelados de aqui se mirar si hay que eliminar un jugador del stage o todos 
pueden continuar, en caso de que todos vuelen se devuelve el dinero acumulado en la ronda a todos
los jugadores y si hay un ganador por puntaje en la ultima ronda se da el dinero a este, o al que gane la etapa

caso de udo AddPoints(adicionarpuntos)
Este caso de usos se da cuando un jugador gana una etapa y obtiene mas aciertos que otros
a este jugador se le adicionan puntos con los cuales puede ganar mas adelante en caso de 
empate en la ultima ronda

caso de uso CreateFirstStageUseCase(CrearPrimeraEtapaCasoUso)
en este caso de uso es cuando ya los jugadores ingresaron a la primer etapa osea la cero
en mi caso se llama CreateCeroStageUseCase que aqui es donde se lanzan los dados pero se mantienen 
ocultos, en esta etapa los jugadores hacen sus apuestas, las cuales pueden incrementar o 
incluso retirarse irse alling eso ya depende de cada jugador y de las regla inpuestas anteriormente
en esta etapa luego de que estan las apuestas se llama showdiceface 3 veces para que me muestre
3 cara de los 6 dados, aqui luego se comparan los resultados con CompareRiddleOnStage,
se toman las decisiones de eliminar jugador etapa dar puntos, devolver saldo o dar salgo a jugador
y se cierra la etapa 

caso uso CreateSecondStageUseCase(CrearSegundaEtapaUseCase)
En esta etapa es similar a la anterior solo que en esta solo se revelan 2 caras del dado
pero se hace lo mismo del CreateFirstStageUseCase.
Este caso de uso sucede despues de CreateFirstStageUseCase.

caso uso CreateThirdStageUseCase(CrearTerceraEtapaUseCase)
En esta etapa es similar a la anterior solo que en esta solo se revelan 1 caras del dado
pero se hace lo mismo del CreateFirstStageUseCase.
Este caso de uso sucede despues de CreateSecondStageUseCase, la unica diferencia es que en este
ya se tiene que tomar la decision de si hay un solo ganador o devolver el dinero en caso que todos 
vuelen a todos los jugadores o de validar por puntos y tambien se encarga de cerrar la ronda.


