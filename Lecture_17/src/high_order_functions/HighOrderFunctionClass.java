package high_order_functions;
// 5/9/19  12:23
public class HighOrderFunctionClass {
	public <T> IFactory<T> createFactory(IProducer<T> producer, IConfigurator<T> configurator) {
		//All of the above I-words are interfaces, each of them has one unimplemented method
		return () -> {
			T instance = producer.produce();
			configurator.configure(instance);
			return instance;
		}; //12:31 This is returning an entire function
	}
}
