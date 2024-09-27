package dao;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;

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
	
}
