# Servicio de ejecución remota de tareas

Se trata de preparar un servidor al que los clientes puedan encargar ejecutar tareas.

El interface de tarea es fijo, para que tanto cliente como servidor sepan a qué atenerse:

    public interface EjecutarTarea extends Remote {
        <T> T ejecutarTarea(Tarea<T> tarea) throws RemoteException
    }

La tarea a ejecutar la define el propio cliente, quien pone a disposición del servidor el código ejecutable (.class) de la misma.

El tipo del resultado `<T>` lo define también el propio cliente, quien pone a disposición del servidor la clase (.class) correspondiente si este tipo es un objeto y no un tipo nativo de Java.

El cliente ha de depositar esos .class en un servidor web. Para que el servidor pueda acceder a ellos.
