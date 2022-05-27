# frozen_string_literal: true

require 'spec_helper'

RSpec.describe 'Actions' do
  it 'pauses' do
    @driver.get 'https://www.selenium.dev/selenium/web/mouse_interaction.html'
    start = Time.now

    clickable = @driver.find_element(id: 'clickable')
    action = @driver.action
    action.move_to(clickable)
          .pause(action.get_device('mouse'), 1)
          .click_and_hold
          .pause(action.get_device('keyboard'), 1)
          .send_keys("abc")
          .perform

    expect(Time.now - start).to be > 2
  end

  it 'releases all' do
    @driver.get 'https://www.selenium.dev/selenium/web/mouse_interaction.html'

    clickable = @driver.find_element(id: 'clickable')
    action = @driver.action
          .click_and_hold(clickable)
          .key_down(:shift)
          .key_down(:alt)
          .key_down("a")
    action.perform
    action.release_actions

    action.key_down('a').perform
    expect(clickable.attribute('value')[0]).to eq "Å"
    expect(clickable.attribute('value')[-1]).to eq "a"
  end
end
