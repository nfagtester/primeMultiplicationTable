import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;

import com.rizwan.AlgoCantHelpException;
import com.rizwan.PrimeNumberFinder;


public class PrimeNumberFinderTest {
	@Test
	public void shouldReturn2AsFirstPrime() throws AlgoCantHelpException{
		//Given
		PrimeNumberFinder finder = new PrimeNumberFinder();
		//When
		List<Integer> result =  finder.getPrimeNumbers(1);
		//Then
		Assert.assertThat("Only one prime is returned", result.size(), is(1));
		Assert.assertThat("2 is returned as first prime", result.get(0), is(2));

	}
	
	@Test
	public void shouldReturn5AsThirdPrime() throws AlgoCantHelpException{
		//Given
		PrimeNumberFinder finder = new PrimeNumberFinder();
		//When
		List<Integer> result =  finder.getPrimeNumbers(3);
		//Then
		Assert.assertThat("3 primes are returned", result.size(), is(3));
		Assert.assertThat("5 is returned as 3rd prime", result.get(2), is(5));
	}
	
	@Test
	public void shouldReturnMoreThan10Primes() throws AlgoCantHelpException{
		//Given
		PrimeNumberFinder finder = new PrimeNumberFinder();
		//When
		List<Integer> result =  finder.getPrimeNumbers(10);
		//Then
		Assert.assertThat("10 primes are returned", result.size(), is(10));
		Assert.assertThat("29 is returned as 10th prime", result.get(9), is(29));
	}
	
	@Test(expected=AlgoCantHelpException.class)
	public void shouldThrowExceptionForLargeInput() throws AlgoCantHelpException{
		//Given
		PrimeNumberFinder finder = new PrimeNumberFinder();
		//When
		List<Integer> result =  finder.getPrimeNumbers(Integer.MAX_VALUE);
		//Then
		//expect exception
	}
}
