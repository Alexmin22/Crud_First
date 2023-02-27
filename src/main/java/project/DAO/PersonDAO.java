package project.DAO;

import org.springframework.stereotype.Component;
import project.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private List<Person> people;
    private static int PeopleCount = 0;

    public PersonDAO(List<Person> people) {
        this.people = people;
        people.add(new Person(++PeopleCount, "Nikita"));
        people.add(new Person(++PeopleCount, "Kirill"));
        people.add(new Person(++PeopleCount, "Daniil"));
        people.add(new Person(++PeopleCount, "Valera"));
        people.add(new Person(++PeopleCount, "Pavel"));
    }
        public List<Person> index() {
            return people;
    }

    public Person show(int id) {
        return people.stream().filter(p -> p.getId() == id).findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(++PeopleCount);
        people.add(person);
    }

    public void update(int id, Person updatedPerson) {
        Person persToBeUpdated = show(id);
        if (persToBeUpdated!= null) {
            persToBeUpdated.setName(updatedPerson.getName());
        }
        }

    public void delete(int id) {
        people.removeIf(p -> p.getId() == id);
        }
    }

