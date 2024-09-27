package dao;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entities.Contact;

/**
 * Classe teste criada para garantir o funcionamento das principais operações
 * sobre contatos, realizadas pela classe {@link ContactManager}
 * @author Victor e Daniela
 *
 */
public class ContactManagerTest {
	
	private ContactManager contactsManager;
	
	private int contactId01 = 1;
	private int contactId02 = 2;
	
	/**
	 *  Criação de um cenário global que será utilizado em todos os testes
	 *  
	 *  @author Victor e Daniela
	 *  @date 27/09/2024
	 */
	@Before
	public void setUp() {
		/*===================== Fase1: Montagem do Cenário Global ===============================*/
		
		//criando alguns contatos
		
		Contact contact01 = new Contact(contactId01, "Carlos", "carlos@email.com", "Rua C, 100");
		Contact contact02 = new Contact(contactId02, "Bruno", "bruno@email.com", "Rua B, 200");
		
		//inserindo os contatos criados na lista de contatos
		
		List<Contact> contacts = new ArrayList<>();
		contacts.add(contact01);
		contacts.add(contact02);
		
		contactsManager = new ContactManager(contacts);
	}
	
	/**
	 *  Desmonte cenário global que foi criado antes de cada teste para 
	 *  manter a consistência e garantir que todos os testes serão feitos com a mesma informação
	 *  
	 *  @author Victor e Daniela
	 *  @date 27/09/2024
	 */
	@After
	public void tearDown() {
		/*===================== Fase4: Desmontagem do Cenário Global ===============================*/
		contactsManager.clean();
		
	}
	
	/**
	 *  Testa o método searchContact(contactId) para o cenário do contato existir na lista
	 *  
	 *  @author Victor e Daniela
	 *  @date 27/09/2024
	 */
	@Test
	public void testSearchContactThatExists() {
		/*======================= Fase2: Execucao do Teste =================================*/
		Contact searchedContact = contactsManager.searchContact(contactId01);
		
		/*===================== Fase3: Verificação e Análise ===============================*/
		assertThat(searchedContact.getId(), is(contactId01));
		assertThat(searchedContact.getName(), is("Carlos"));
		assertThat(searchedContact.getEmail(), is("carlos@email.com"));
		assertThat(searchedContact.getAdress(), is("Rua C, 100"));
		
	}
	
	/**
	 *  Testa o método searchContact(contactId) para o cenário do contato não existir na lista
	 *  
	 *  @author Victor e Daniela
	 *  @date 27/09/2024
	 */
	@Test
	public void testSearchContactThatDoesNotExist() {
		/*======================= Fase2: Execucao do Teste =================================*/
		Contact searchedContact = contactsManager.searchContact(18);
		
		/*===================== Fase3: Verificação e Análise ===============================*/
		assertNull(searchedContact);
	}
	
	/**
	 *  Testa o método removeContact(contactId) para o cenário do contato existir na lista
	 *  
	 *  @author Victor e Daniela
	 *  @date 27/09/2024
	 */
	@Test
	public void testRemoveContactThatExists() {		
		/*===================== Fase2: Execucao do Teste ===============================*/
		
		
		boolean removedStatus = contactsManager.removeContact(contactId01);
		
		/*===================== Fase3: Verificação e Análise ===============================*/
		
		assertThat(contactsManager.getContactList().size(), is(1));
		assertNull(contactsManager.searchContact(contactId01));
		assertTrue(removedStatus);
	}
	
	/**
	 *  Testa o método removeContact(contactId) para o cenário do contato não existir na lista
	 *  
	 *  @author Victor e Daniela
	 *  @date 27/09/2024
	 */
	@Test
	public void testRemoveContactThatDoesNotExists() {		
		/*===================== Fase2: Execucao do Teste ===============================*/
		
		boolean removedStatus = contactsManager.removeContact(18);
		
		/*===================== Fase3: Verificação e Análise ===============================*/
		
		assertThat(contactsManager.getContactList().size(), is(2));
		assertFalse(removedStatus);
	}
	
	/**
	 *  Testa o método addContact(ContactInfo) para o cenário do se criar um contato corretamente
	 *  
	 *  @author Victor e Daniela
	 *  @date 27/09/2024
	 */
	@Test
	public void testAddContactCorrectly() {
		/*================ Fase1: Cenário customizado para o teste  ========================*/
		Contact contact = new Contact(3, "Juliana", "juliana@email.com", "Rua J, 300");
		
		/*===================== Fase2: Execucao do Teste ===============================*/
		
		Contact createdContact =contactsManager.addContact(contact);
		
		/*===================== Fase3: Verificação e Análise ===============================*/
		
		assertThat(createdContact.getId(), is(3));
		assertThat(createdContact.getName(), is("Juliana"));
		assertThat(createdContact.getEmail(), is("juliana@email.com"));
		assertThat(createdContact.getAdress(), is("Rua J, 300"));
		assertThat(contactsManager.getContactList().size(), is(3));
	}
	
	/**
	 *  Testa o método addContact(ContactInfo) para o cenário do se criar um contato corretamente
	 *  
	 *  @author Victor e Daniela
	 *  @date 27/09/2024
	 */
	@Test
	public void testAddContactIncorrectly() {		
		/*===================== Fase2: Execucao do Teste ===============================*/
		
		Contact createdContact =contactsManager.addContact(null);
		
		/*===================== Fase3: Verificação e Análise ===============================*/
		
		assertNull(createdContact);
		assertThat(contactsManager.getContactList().size(), is(2));
	}
	
}
