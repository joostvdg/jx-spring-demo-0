package net.kearos.jx.jxspringdemo0

import net.kearos.jx.jxspringdemo0.model.Greeting

import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest(
		classes = arrayOf(DemoApplication::class),
		webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoApplicationTests {

	@Test
	fun contextLoads() {
	}

	@Autowired
	lateinit var testRestTemplate: TestRestTemplate

	@Test
	fun whenCalled_shouldReturnHello() {
		val result = testRestTemplate.getForEntity("/hello", String::class.java)
		assertNotNull(result)
		assertEquals(HttpStatus.OK, result?.statusCode)
		assertEquals(result?.body, "Hello world")
	}

	@Test
	fun whenCalled_shouldReturnGreetings() {
		val result = testRestTemplate.getForEntity("/greeting", Greeting::class.java)
		assertNotNull(result)
		assertEquals(HttpStatus.OK, result?.statusCode)
		assertEquals(result?.body, Greeting("Greetings"))
	}
}

