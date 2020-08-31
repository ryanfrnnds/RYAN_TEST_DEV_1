import { cyan } from "color-name"
import { AssertionError } from "assert"

/*
Task #4
Write down a simple integration test to the task #3 you did before.
No need to check all the data retrieved by the button pushing. Just a Company name would be enough !
*/
describe('Test to be fulfilled by the candidate', () => {
  it('push the button implemented on task #3 and shows the company names', () => {
      cy.visit('http://localhost:4200')
      cy.server()
      cy.route({
        method: 'GET',
        url: 'http://localhost:8080/company/standartDeviations',
      }).as('companies')

      cy.get('[data-cy=getCompanies]').click()

      cy.wait('@companies').then((xhr) => {
        let companies = xhr.response.body;
        expect(companies.length).to.equal(3)
        expect(companies[0].company.toUpperCase()).to.equal('railroad'.toUpperCase())
        expect(companies[1].company.toUpperCase()).to.equal('carriers'.toUpperCase())
        expect(companies[2].company.toUpperCase()).to.equal('navigation'.toUpperCase())
      })
  })
})
